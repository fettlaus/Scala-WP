package de.haw.scala.A4.T1

object BigIntMain {
  val exp: (Int, Int) => Either[BigDecimal, BigInt] = (i, n) => {
    import scala.annotation._
    import java.math.MathContext._
    import java.math.MathContext
    @tailrec
    def ex(n: Int, r: BigInt): BigInt = if (n == 0) r else ex(n - 1, r * BigInt(i))

    if (n < 0)
      Left(BigDecimal(1, DECIMAL128) / BigDecimal(ex(-n, BigInt(1))))
    else
      Right(ex(n, BigInt(1)))
  };

  def main(args: Array[String]): Unit = {
    println(exp(2, 4));
    println(exp(2, -4));
    println(exp(3, 2));
    println(exp(3, -1));
    println(exp(9, 30));
    println(exp(9, -30));
  }
}
