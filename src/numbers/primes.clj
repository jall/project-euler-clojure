(ns numbers.primes)

(defn next-divisor
  "Figure out the next best divisor to use.
  Currently only skips even numbers (assuming base case of 2)."
  [divisor]
  (if (even? divisor)
    (+' 1 divisor)
    (+' 2 divisor)))

(defn divisible-by?
  [divisor number]
  (zero? (mod number divisor)))

(defn prime-factors
  "Returns a list of all prime factors of a number"
  ([number]
   (prime-factors number 2 '()))
  ([number divisor divisors]
    ; Base case - if number has been cut down to one, then return divisors.
   (if (= 1 number)
     divisors
     (if (divisible-by? divisor number)
       ; Extract divisor from the number & append to divisors
       (recur (quot number divisor) divisor (conj divisors divisor))
       ; Move on to next divisor
       (recur number (next-divisor divisor) divisors)))))

(defn aggregate-primes [primes, prime]
  (conj primes {prime (inc (get primes prime 0))}))

(defn prime-factors-grouped
  "Returns a map of the numbers prime factors, where keys are the primes
  and values are the power the primes are raised to in the factorisation."
  [number]
  (reduce aggregate-primes {} (prime-factors number)))
