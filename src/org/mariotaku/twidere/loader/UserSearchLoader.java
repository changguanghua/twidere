package org.mariotaku.twidere.loader;

import static org.mariotaku.twidere.util.Utils.getTwitterInstance;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import android.content.Context;

public class UserSearchLoader extends UsersLoader {

	private final Twitter mTwitter;
	private final String mQuery;
	private final int mPage;

	public UserSearchLoader(Context context, long account_id, String query, int page) {
		super(context, account_id);
		mTwitter = getTwitterInstance(context, account_id, true);
		mQuery = query;
		mPage = page;
	}

	@Override
	public ResponseList<User> getUsers() throws TwitterException {
		return mTwitter.searchUsers(mQuery, mPage);
	}

}