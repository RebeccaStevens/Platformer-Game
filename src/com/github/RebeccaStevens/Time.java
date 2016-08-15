package com.github.RebeccaStevens;

public final class Time {
	
	/**
	 * The Time class does not need a public constructor.
	 */
	private Time() {}
	
	/**
	 * The timeFactor is the relation between the timeFrame and the timeStep.
	 * timeFrame * timeFactor = timeStep
	 */
	private static float timeFactor = 1F;
	
	/**
	 * The timeFrame is the amount of actual time that has passed since the last frame.
	 */
	private static float timeFrame = 0F;
	
	/**
	 * The timeStep is the amount of in game time that has passed since the last frame.
	 */
	private static float timeStep = 0F;
	
	/**
	 * The time in milliseconds. Used to calculate timeFrame and timeStep
	 */
	private static long timeStamp = 0L;
	
	/**
	 * @return The timeStep 
	 */
	public static float getTimeStep() {
		return Time.timeStep;
	}

	/**
	 * @return The timeFrame 
	 */
	public static float getTimeFrame() {
		return Time.timeFrame;
	}

	/**
	 * @return the timeFactor
	 */
	public static float getTimeFactor() {
		return Time.timeFactor;
	}

	/**
	 * @param timeFactor
	 */
	public static void setTimeFactor(float timeFactor) {
		Time.timeFactor = timeFactor;
	}
	
	/**
	 * Update the values of timeFrame and timeStep.
	 * This method should be called once every frame.
	 */
	public static void update() {
		long newTimeStamp = System.currentTimeMillis();
		Time.timeFrame = (newTimeStamp - Time.timeStamp) / 1000F;
		Time.timeStep = Time.timeFactor * Time.timeFrame;
		Time.timeStamp = newTimeStamp;
	}
}
