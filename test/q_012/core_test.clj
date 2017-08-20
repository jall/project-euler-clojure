(ns q-012.core-test
  (:require [clojure.test :refer :all]
            [q-012.core :refer :all]))

(deftest q-012-test
  (is (= (-main) 76576500)))
