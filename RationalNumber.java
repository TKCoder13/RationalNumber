public class RationalNumber implements RationalNumberInterface {
    
    private int numerator;
    private int denominator;

    // -- Default Constructor
    public RationalNumber() {
        this.numerator = 0;
        this.denominator = 1;
    }

    
    public RationalNumber(int numerator, int denominator) throws ArithmeticException {
        this.numerator = numerator;
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be 0");
        } else {
            this.denominator = denominator;
        }  
    }

    // -- Copy Constructor
    public RationalNumber(RationalNumber rhs) throws ArithmeticException {
        this.numerator = rhs.getNumerator();
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be 0");
        } else {
            this.denominator = rhs.getDenominator();
        }
    }

    public RationalNumber(RationalNumberInterface lhs) throws ArithmeticException {
        this.numerator = lhs.getNumerator();
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be 0");
        } else {
            this.denominator = this.getDenominator();
        }
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    @Override
    public boolean equals(Object obj) {
		if (obj instanceof RationalNumber) {
			RationalNumber rnObj = (RationalNumber) obj;
			if (rnObj.getNumerator() == this.getNumerator() &&
            rnObj.getDenominator() == this.getDenominator()) {
                return true;
            } else {
                return false;
            } 
		} else {
			return false;
		}
	}

    @Override
    public String toString() {
        int currentNumerator = this.getNumerator();
        int currentDenominator = this.getDenominator();

        // -- Checks for negative values
        boolean isNegative = false;
        if (currentNumerator < 0) isNegative = !isNegative;
        if (currentDenominator < 0) isNegative = !isNegative;

        currentNumerator = Math.abs(currentNumerator);
        currentDenominator = Math.abs(currentDenominator);

        int wholeNumber = Math.abs(currentNumerator / currentDenominator);
        int remainder = Math.abs(currentNumerator % currentDenominator);
        String output = "";

        // -- Reduce improper fractions
        int gcd = getGCD(remainder, currentDenominator);
        if (gcd > 1) {
            remainder = remainder / gcd;
            currentDenominator = currentDenominator / gcd;
        }

        if (isNegative) {
            if (wholeNumber == 0) {
                if (remainder == 0) {
                    return output + "-" + wholeNumber;
                } else {
                    return output + "-" + remainder + "/" + currentDenominator;
                }
            } else {
                if (remainder == 0) {
                    return output + "-" + wholeNumber;
                } else {
                    return output + "-" + wholeNumber + " " + remainder + "/" + currentDenominator;
                }
            }
        } else {
            if (wholeNumber == 0) {
                if (remainder == 0) {
                    return output + wholeNumber;
                } else {
                    return output + remainder + "/" + currentDenominator;
                }
            } else {
                if (remainder == 0) {
                    return output + wholeNumber;
                } else {
                    return output + wholeNumber + " " + remainder + "/" + currentDenominator;
                }
            }
        }
    }

    private int getGCD(int num1, int num2) {
        int gcd = 1;
        for (int i = 1; i <= num1 && i <= num2; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public RationalNumberInterface add(RationalNumberInterface rhs) {
        
        int leftNumerator = this.getNumerator() * rhs.getDenominator();
        int rightNumerator = rhs.getNumerator() * this.getDenominator();

        int tempNumerator = leftNumerator + rightNumerator;
        int tempDenominator = this.getDenominator() * rhs.getDenominator();
        
        int endNumerator;
        int endDenominator;

        int gcd = getGCD(tempNumerator, tempDenominator);
        if (gcd == 1) {
            RationalNumber output = new RationalNumber(tempNumerator, tempDenominator);
            return output;
        } else {
            tempNumerator = tempNumerator / gcd;
            tempDenominator = tempDenominator / gcd;
            RationalNumber output = new RationalNumber(tempNumerator, tempDenominator);
            return output;
        }
    }

    public RationalNumberInterface sub(RationalNumberInterface rhs) {
        int leftNumerator = this.getNumerator() * rhs.getDenominator();
        int rightNumerator = rhs.getNumerator() * this.getDenominator();

        int tempNumerator = leftNumerator - rightNumerator;
        int tempDenominator = this.getDenominator() * rhs.getDenominator();
        
        int endNumerator;
        int endDenominator;

        int gcd = getGCD(tempNumerator, tempDenominator);
        if (gcd == 1) {
            RationalNumber output = new RationalNumber(tempNumerator, tempDenominator);
            return output;
        } else {
            tempNumerator = tempNumerator / gcd;
            tempDenominator = tempDenominator / gcd;
            RationalNumber output = new RationalNumber(tempNumerator, tempDenominator);
            return output;
        }
    }

    public RationalNumberInterface mult(RationalNumberInterface rhs) {
        int currentNumerator = this.getNumerator() * rhs.getNumerator();
        int currentDenominator = this.getDenominator() * rhs.getDenominator();
        RationalNumber output = new RationalNumber(currentNumerator, currentDenominator);
        return output;
    }

    public RationalNumberInterface div(RationalNumberInterface rhs) throws ArithmeticException {
        try {
            int outNumerator = this.getNumerator() * rhs.getDenominator();
            int outDenominator = this.getDenominator() * rhs.getNumerator();
            RationalNumber output = new RationalNumber(outNumerator, outDenominator);
            return output;
        } catch (ArithmeticException a) {
            throw new ArithmeticException("Cannot be divisible by 0");
        }
    }

    public double sqrt() throws ArithmeticException {
        double sqrtOutput;
        if (Math.sqrt((double) this.getNumerator() / (double) this.getDenominator()) < 0) {
            throw new ArithmeticException("You cannot square root a negative number");
        } else {
            sqrtOutput = Math.sqrt((double) this.getNumerator() / (double) this.getDenominator());
        }
        return sqrtOutput;
    }

}
