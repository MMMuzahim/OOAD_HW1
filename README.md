# Random Number Generator

## Overview
This Java project implements a statistical analysis tool to compare different random number generation methods provided by the Java Standard Library. It evaluates the distribution of generated values by calculating descriptive statistics as the sample size increases.

## Educational Demonstrations
This project serves as a demonstration of core Java concepts, including:
* **Class Definition**: The structure of the `Generator` class.
* **Method Definition**: Implementation of logic-specific blocks like `populate` and `statistics`.
* **Object Instantiation**: Creating instances of `Generator` and `Random`.
* **Accessibility**: Use of `public` and `private` modifiers.
* **Class Attributes**: Usage of member variables for configuration.

## Generation Methods
The program compares three distinct approaches:
1. **java.util.Random**: A thread-safe, linear congruential generator.
2. **Math.random()**: A simple wrapper around `java.util.Random`.
3. **java.util.concurrent.ThreadLocalRandom**: Optimized for multi-threaded environments.

## Statistical Calculations
For every dataset, the program calculates:
* **Mean ($\bar{x}$)**: The average of all generated numbers.
* **Sample Standard Deviation ($s$)**: Measures the dispersion of data from the mean.
* **Min/Max**: The range boundaries of the generated sample.
