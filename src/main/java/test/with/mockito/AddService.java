package test.with.mockito;

import javax.inject.Singleton;

@Singleton
public class AddService {
	public Result add(int a, int b) {
		return new Result(a + b);
	}
}
