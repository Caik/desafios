package crawlers.desafios.bot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RedditBotTest {

	@Test
	public void getSubReddits() {
		RedditBot bot = new RedditBot();

		assertEquals(bot.getSubReddits("").size(), 0);
		assertEquals(bot.getSubReddits("subreddit1").size(), 1);
		assertEquals(bot.getSubReddits("subreddit1;subreddit1;").size(), 2);
		assertEquals(bot.getSubReddits("subreddit1;subreddit2;subreddit3").size(), 3);
	}
}
