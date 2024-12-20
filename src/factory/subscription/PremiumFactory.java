package factory.subscription;

import model.subscription.Premium;
import model.subscription.Subscription;

public class PremiumFactory extends SubscriptionFactory {
	@Override
	public Subscription createSubscription() {
		return new Premium("Premium", 9.99, "1 Month");
	}
}
