package test.with.mockito;

import javax.inject.Singleton;

@Singleton
public class MultiplyService {
	public Result mult(int a, int b) {
		return new Result(a * b);
	}
}
