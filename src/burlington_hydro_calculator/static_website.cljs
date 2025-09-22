(ns burlington-hydro-calculator.static-website)

(def periods [{:title "Weekdays 7 am to 11 am"
               :tou-price 12.2
               :ulo-price 12.2
               :hour-range [7 11]
               :weekday? true}
              {:title "Weekdays 11 am to 4 pm"
               :tou-price 15.8
               :ulo-price 12.2
               :hour-range [11 16]
               :weekday? true}
              {:title "Weekdays 4 pm to 5 pm"
               :tou-price 15.8
               :ulo-price 28.4
               :hour-range [16 17]
               :weekday? true}
              {:title "Weekdays 5 pm to 7 pm"
               :tou-price 12.2
               :ulo-price 28.4
               :hour-range [17 19]
               :weekday? true}
              {:title "Weekdays 7 pm to 9 pm"
               :tou-price 7.6
               :ulo-price 28.4
               :hour-range [19 21]
               :weekday? true}
              {:title "Weekdays 9 pm to 11 pm"
               :tou-price 7.6
               :ulo-price 12.2
               :hour-range [21 23]
               :weekday? true}
              {:title "Weekdays 11 pm to 7 am"
               :tou-price 7.6
               :ulo-price 2.8
               :hour-range [23 7]
               :weekday? true}
              {:title "Weekends and holidays 7 am to 11 pm"
               :tou-price 7.6
               :ulo-price 7.6
               :hour-range [7 23]
               :weekday? false}
              {:title "Weekends and holidays 11 pm to 7 am"
               :tou-price 7.6
               :ulo-price 2.8
               :hour-range [23 7]
               :weekday? false}])

(def holidays-api-url "https://canada-holidays.ca/api/v1/holidays")

(defn periods-table-html []
  (let [header "<table>
                 <thead>
                  <tr>
                   <th>Period</th>
                   <th>TOU Price</th>
                   <th>ULO Price</th>
                  <th>Avg. kWh per hour</th>
                  <th>TOU Cost</th>
                  <th>ULO Cost</th></tr></thead><tbody>"
        rows (apply str
                    (for [{:keys [title tou-price ulo-price]} periods]
                      (str "<tr>"
                           "<td>" title "</td>"
                           "<td>" tou-price "</td>"
                           "<td>" ulo-price "</td>"
                           "<td> 12 kWh/h</td>"
                           "<td> 3.213 C$/h </td>"
                           "<td> 2.412 C$/h </td>"
                           "</tr>")))
        footer "</tbody></table>"]
    (str header rows footer)))

(let [table-html (periods-table-html)
      hourly-prices-div (.getElementById js/document "costs-per-period")]
  (set! (.-innerHTML hourly-prices-div) table-html))