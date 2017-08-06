(ns q-007.core
  (:gen-class)
  (:require [numbers.primes :refer [prime-seq]]))

(defn -main
  "10001st prime"
  [& args]
  ; Holy shit this is slow for longer seqs (i.e. >100)
  (def answer (take 100 (prime-seq)))
  (println answer)
  answer)
