(ns strings.conversion)

(defn character-to-digit [^Character character]
  (Character/getNumericValue character))

(defn string-to-digits [string]
  (map character-to-digit string))
