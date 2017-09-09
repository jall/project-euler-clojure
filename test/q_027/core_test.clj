(ns q-027.core-test
  (:require [clojure.test :refer :all]
            [q-027.core :refer :all]))

(deftest q-027-test
  (is (= (-main) -59231)))
