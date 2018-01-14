package org.echoClasses;

import java.util.ArrayList;
import java.util.Random;

public class myAllTargets {
	private static final long serialVersionUID = 1;
	ArrayList<Target> targets;

	public myAllTargets() {
		targets = new ArrayList<Target>();
	}

	public void addTarget(Target t1) {
		this.targets.add(t1);
	}

	public ArrayList<Target> getTarget(myAllTargets targetList) {

		return targets;
	}

	public void removeAllTargets() {

		this.targets.clear();

	}

	public void removeTarget(Target t1) {
		this.targets.remove(t1);

	}

	public static int randInt(int lowerbound, int upperbound) {

		Random rand = new Random();
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((upperbound - lowerbound) + 1) + lowerbound;

		return randomNum;

	}

	public static void printSingleTargetInfo(Target atarget) {
		System.out.println("centreX : " + atarget.getCentreX());
		System.out.println("centreY : " + atarget.getCentreY());

	}

	public static void printTargetInfo(ArrayList<Target> currentTargets, int x) {
		double centreX = currentTargets.get(x).getCentreX();
		double centreY = currentTargets.get(x).getCentreY();
		long ms = currentTargets.get(x).getSetmstime();

		System.out.println("centreX : " + centreX);
		System.out.println("centreY : " + centreY);
		System.out.println("ms time : " + ms);
	}

	public static int findSmallestCXInTargets(ArrayList<Target> currentTargets) {

		// iterate over current targets, and return index of target with smallest
		// CentreX

		double smallestCX;
		int interestingtarget;

		smallestCX = 1000;
		interestingtarget = -1;

		for (Target target : currentTargets) {

			if (target.checkifValidTarget(target) && target.getCentreX() < smallestCX) {
				smallestCX = target.getCentreX();
				interestingtarget = currentTargets.indexOf(target);
			}

		}

		return interestingtarget;

	}

	public static int findLargestCXInTargets(ArrayList<Target> currentTargets) {

		// iterate over current targets, and return index of target with smallest
		// CentreX

		double largestCX;
		int interestingtarget;

		largestCX = -1;
		interestingtarget = -1;

		for (Target target : currentTargets) {

			if (target.checkifValidTarget(target) && target.getCentreX() > largestCX) {
				largestCX = target.getCentreX();
				interestingtarget = currentTargets.indexOf(target);
			}

		}

		return interestingtarget;

	}

}
