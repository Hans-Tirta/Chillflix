package factory.subscription;

import model.subscription.Free;
import model.subscription.Subscription;

public class FreeFactory extends SubscriptionFactory {
	@Override
	public Subscription createSubscription() {
		return new Free("Free", 0.0, "Unlimited");
	}
}
