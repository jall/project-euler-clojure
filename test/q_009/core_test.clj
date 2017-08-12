(ns q-009.core-test
  (:require [clojure.test :refer :all]
            [q-009.core :refer :all]))

(deftest q-009-test
  (is (= (-main) 31875000)))
