public interface RationalNumberInterface {

	// -- Include the following constructors
	//
	// -- constructs with numerator of 0, denominator of 1
	//    public RationalNumber()
	//
	// -- constructs with numerator of n, denominator of d, 
	//	  throws exception if d is 0
	//    public RationalNumber(int n, int d) throws IllegalArgumentException	
	//
	// -- constructs with numerator of rhs.numerator, denominator 
	//	  of rhs.denominator
	//    public RationalNumber(RationalNumber rhs)
	/**
	 * @return numerator
	 */
	public int getNumerator();

	/**
	 * @return denominator
	 */
	public int getDenominator();

	/**
	 * @return true if o.numerator == this.numerator and
	 *                 o.denominator == this.denominator
	 *         false otherwise
	 */
	
	@Override
	public boolean equals(Object o);

	/**
	 * 
	 * @return  a string in simplified, proper form. e.g.
     *	n = 1, d = 2 returns "1/2"
     *	n = 10, d = 20 returns "1/2"
     *	n = 20, d = 5 returns "4"
     *	n = 20, d = 6 returns "3 1/3"
     *	n = -20, d = 6 returns "-3 1/3"
     *	n = 20, d = -6 returns "-3 1/3"
     *	etc.
	 */
	@Override
	public String toString();

	/**
	 * @param rhs right hand side operand
	 * @return this + rhs
	 */
	public RationalNumberInterface add(RationalNumberInterface rhs);
	/**
	 * @param rhs right hand side operand
	 * @return this - rhs
	 */
	public RationalNumberInterface sub(RationalNumberInterface rhs);
	/**
	 * @param rhs right hand side operand
	 * @return this * sub
	 */
	public RationalNumberInterface mult(RationalNumberInterface rhs);
	/**
	 * @param rhs right hand side operand
	 * @return this / rhs
	 * @throws ArithmeticException if rhs == 0
	 */
	public RationalNumberInterface div(RationalNumberInterface rhs) throws ArithmeticException;
	/**
	 * @return sqrt((double)this.numerator/(double)this.denominator)
	 * @throws ArithmeticException if this is negative
	 */
	public double sqrt() throws ArithmeticException;

}