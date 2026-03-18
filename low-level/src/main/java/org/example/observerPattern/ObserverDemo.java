package org.example.observerPattern;

public class ObserverDemo {
	public static void main(String [] args) {
		Subscription newsPaperSubscription = new NewsPaperSubscription();
		Subscription magazineSubscriptoin = new MagazineSubscription();

		Subscriber normalPerson = new Person();
		Subscriber company = new Company();

		newsPaperSubscription.addSubscriber(normalPerson);
		magazineSubscriptoin.addSubscriber(company);
		magazineSubscriptoin.addSubscriber(normalPerson);

		magazineSubscriptoin.removeSubscriber(company);

		newsPaperSubscription.updateLatestEdition(new Edition("e1",
				EditionType.NEWSPAPER));
		magazineSubscriptoin.updateLatestEdition(new Edition("m1",
				EditionType.MAGAZINE));
	}
}
