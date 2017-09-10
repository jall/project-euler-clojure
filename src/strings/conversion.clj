(ns strings.conversion
  (:gen-class))

(defn character-to-digit [^Character character]
  (Character/getNumericValue character))

(defn string-to-digits [string]
  (map character-to-digit string))

(defn number-to-digits [n]
  (string-to-digits (str n)))
