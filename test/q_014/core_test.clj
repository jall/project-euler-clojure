(ns q-014.core-test
  (:require [clojure.test :refer :all]
            [q-014.core :refer :all]))

(deftest q-014-test
  (is (= (-main) 837799)))
