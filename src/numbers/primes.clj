(ns numbers.primes)

(defn next-divisor
  "Figure out the next best divisor to use.
  Currently only skips even numbers (assuming base case of 2)."
  [divisor]
  (if (even? divisor)
    (+ 1 divisor)
    (+ 2 divisor)))

(defn divisible-by?
  [number divisor]
  (zero? (mod number divisor)))

(defn prime-factors
  "Returns a list of all prime factors of a number"
  ([number]
   (prime-factors number 2 '()))
  ([number divisor divisors]
    ; Base case - if number has been cut down to one, then return divisors.
   (if (= 1 number)
     divisors
     (if (divisible-by? number divisor)
       ; Extract divisor from the number & append to divisors
       (prime-factors (quot number divisor) divisor (cons divisor divisors))
       ; Move on to next divisor
       (prime-factors number (next-divisor divisor) divisors)))))
