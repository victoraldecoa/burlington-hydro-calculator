(ns tests.burlington-hydro-calculator.static-website-tests
  (:require [cljs.test :refer-macros [deftest is testing run-tests]]))

(deftest test-numbers
  (is (= 1 1)))

(cljs.test/run-tests)