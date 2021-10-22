package com.tamplan.sample.store.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RentalFilmStoreCoreApplication {

	private static Logger logger = LoggerFactory.getLogger(RentalFilmStoreCoreApplication.class);

	public static void main(String[] args) {
		//SpringApplication.run(RentalFilmStoreCoreApplication.class, args);

		logger.info("Core service started...");


		//System.out.println(solution("Wed", 500));
		System.out.println(solution2(new int[]{1,4,1}, new int[]{1,5,1}));

		System.out.println(solution2(new int[]{4, 4, 2, 4}, new int[]{5, 5, 2, 5}));

		//System.out.println(n[4, 4, 2, 4], [5, 5, 2, 5]

	}

	public static String solution(String S, int K) {
		final List<String> DAYS = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");

		int indexFound = DAYS.indexOf(S);

		if ( indexFound == -1 ) {
			return "";
		}

		int rem  = (indexFound + K) % 7;

		return DAYS.get(rem);
	}

	public static int  solution2(int[] P, int[] S) {

		/*
		int[] availableSeats = new int[P.length];

		for(int i=0; i < P.length; i++) {
			availableSeats[i] = S[i]-P[i];
		}

		for(int i=0; i <availableSeats.length; i++) {
			for(int car = 0; car < availableSeats[i]; car++) {
				if ( availableSeats[car] > 0 ) {

				}
			}
		}

		 */
		int reqCars  = calcRequiredCars(P);

		for(int car=0; car < P.length; car++) {
			int newReqCar = calc(P, S, car, reqCars);

			if ( newReqCar < reqCars ) {
				reqCars = newReqCar;


			}

		}

		return reqCars;
	}

	public static int calc(int[] P, int[] S, int curCar, int reqCars) {
		if ( curCar > P.length ) {
			return  reqCars;
		}

		for(int car=curCar; car < P.length; car++) {
			int nextCar = (car+1) % P.length;

			// if there is some space
			int diff = S[nextCar] - P[nextCar];

			if ( diff > 0 ) {
				int spaceToAllocate = Math.min(diff, P[car]);

				P[nextCar] = P[nextCar] + spaceToAllocate;
				P[car] = P[car] - spaceToAllocate;

				int currentRequired = calcRequiredCars(P);

				if ( currentRequired < reqCars ) {
					return calc(P, S, curCar+1, currentRequired);
				}else {
					return calc(P, S, curCar+1, reqCars);
				}
			}
		}

		return reqCars;
	}

	public static int calcRequiredCars(int []P) {
		int total = 0;

		for(int i=0; i < P.length; i++) {
			if ( P[i] > 0 ) {
				total++;
			}
		}

		return total;
	}


	}
