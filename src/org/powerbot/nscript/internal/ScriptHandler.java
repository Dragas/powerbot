package org.powerbot.nscript.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

import org.powerbot.nscript.Script;
import org.powerbot.nscript.lang.Stoppable;
import org.powerbot.nscript.lang.Suspendable;

public class ScriptHandler implements Suspendable, Stoppable {
	private ExecutorService executor;
	private AtomicReference<Script> script;

	public ScriptHandler() {
		this.executor = new ScriptExecutor();
		this.script = new AtomicReference<>(null);
	}

	public boolean start(Script script) {
		if (this.script.compareAndSet(null, script)) {
			script.getTriggers(Script.Event.START).offerLast(new FutureTask<>(script, true));
			if (call(Script.Event.START)) return true;
			else this.script.set(null);
		}
		return false;
	}

	@Override
	public boolean isStopping() {
		return false;
	}

	@Override
	public void stop() {
	}

	@Override
	public boolean isSuspended() {
		return false;
	}

	@Override
	public void setSuspended(boolean suspended) {
	}

	public ExecutorService getExecutor() {
		return executor;
	}

	private boolean call(Script.Event event) {
		Script script = this.script.get();
		if (script == null) return false;

		Collection<FutureTask<Boolean>> tasks = script.getTriggers(event);
		List<FutureTask<Boolean>> pending = new ArrayList<>(tasks.size());
		pending.addAll(tasks);

		Executor service = getExecutor();
		for (FutureTask<Boolean> task : pending) {
			service.execute(task);
			boolean result = false;
			try {
				result = task.get();
			} catch (InterruptedException | ExecutionException ignored) {
			}
			if (!result) break;
		}
		return true;
	}
}
