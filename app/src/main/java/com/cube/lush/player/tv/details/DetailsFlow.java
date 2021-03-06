package com.cube.lush.player.tv.details;

import android.support.annotation.NonNull;

import com.lush.player.api.model.Programme;

/**
 * Defines a flow of events used on the {@link ProgrammeDetailsFragment} in order to populate and correctly reveal the details and background content.
 *
 * @author Jamie Cruwys
 */
public interface DetailsFlow
{
	/**
	 * Populates the content view and makes it visible.
	 * <p/>
	 * The implementing class should call this once they have fetched the details of the {@link Programme} item that will be displayed. If an item could not
	 * be fetched then {@link #populateError(Runnable)} should be called.
	 */
	void populateContentView(Programme item);

	/**
	 * Displays an error to the user.
	 *
	 * @param retryAction
	 *  A runnable that will retry fetching the data needed to populate the content view.
	 */
	void populateError(Runnable retryAction);

	/**
	 * Populates the hidden content view with the given {@link Programme}.
	 * This should be called when the content view has been successfully revealed.
	 * You MUST call {@link #revealHiddenView()} at the end of your implementation of this method.
	 *
	 * @param item
	 * 				that will be used to populate the view
	 */
	void populateHiddenView(@NonNull Programme item);

	/**
	 * Makes the hidden content view visible.
	 * This should only be called when the hidden content view has been successfully populated.
	 * If any loading is asynchronous, then this should be called once all asynchronous populating has been completed.
	 */
	void revealHiddenView();
}
