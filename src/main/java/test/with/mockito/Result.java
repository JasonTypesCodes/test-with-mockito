package test.with.mockito;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Result {
	private int result;

	public Result(int result) {
		this.result = result;
	}

	public int getResult() {
		return this.result;
	}
}
