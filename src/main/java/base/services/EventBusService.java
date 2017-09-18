package base.services;

import base.models.TestEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import java.util.Objects;
import java.util.function.Consumer;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by kongxiangwen on 9/18/17.
 */
@Service
public class EventBusService {

	public static class Handler {

		private final Consumer<TestEvent> consumer;

		public Handler(Consumer<TestEvent> consumer) {
			this.consumer = Objects.requireNonNull(consumer, "consumer cannot null");
		}

		@Subscribe
		private void onDomainEvent(TestEvent event) {
			consumer.accept(event);
		}
	}


	//@Resource
	private EventBus eventBus = new EventBus();


	@PostConstruct
	void init()
	{
		eventBus.register(this);
	}


	@Subscribe
	public void listen(TestEvent event) {
		String lastMessage = event.getMessage();
		System.out.println("Get event message:"+lastMessage);
	}

	public void postEvent(TestEvent event) {
		eventBus.post(event);
	}


	public void registerNewEventHandler(Consumer<TestEvent> consumer) {
		eventBus.register(new Handler(consumer));
	}

}
