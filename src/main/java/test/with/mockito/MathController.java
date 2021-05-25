package test.with.mockito;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/math")
public class MathController {

	private AddService addService;
	private MultiplyService multiplyService;

	public MathController(AddService addService, MultiplyService multiplyService) {
		this.addService = addService;
		this.multiplyService = multiplyService;
	}

	@Get("/add/{a}/{b}")
	public Result add(Integer a, Integer b) {
		return addService.add(a, b);
	}

	@Get("/multiply/{a}/{b}")
	public Result multiply(Integer a, Integer b) {
		return multiplyService.mult(a, b);
	}
}
