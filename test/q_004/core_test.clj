(ns q-004.core-test
  (:require [clojure.test :refer :all]
            [q-004.core :refer :all]))

(deftest q-004-test
    (is (= (-main) 906609)))
