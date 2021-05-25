package test.with.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

import static org.mockito.Mockito.*;

@MicronautTest
public class MathControllerTest {
	@Inject
	@Client("/math")
	HttpClient client;

	@Inject
	AddService addService;

	@MockBean(AddService.class)
	AddService mockAddService() {
		AddService mockAddService = mock(AddService.class);

		when(mockAddService.add(anyInt(), anyInt())).thenReturn(new Result(42));

		return mockAddService;
	}

	@Test
	void testAdd() {
		HttpResponse<Result> res = client.toBlocking().exchange(HttpRequest.GET("/add/2/3"), Result.class);

		assertEquals(42, res.getBody().get().getResult());
		verify(addService, times(1)).add(anyInt(), anyInt());
	}

	@Test
	void testMultiply() {
		HttpResponse<Result> res = client.toBlocking().exchange(HttpRequest.GET("/multiply/2/3"), Result.class);

		assertEquals(6, res.getBody().get().getResult());
	}
}
