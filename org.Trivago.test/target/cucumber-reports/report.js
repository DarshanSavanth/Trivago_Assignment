$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("search.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Darshan Savanth"
    },
    {
      "line": 2,
      "value": "#Feature: Trivago standard search scenarios"
    },
    {
      "line": 3,
      "value": "#Background: List of steps run before each of the scenarios"
    }
  ],
  "line": 5,
  "name": "Standard search",
  "description": "To check that the user is able to use the standard search feature of Trivago, view the results and navigate to appropriate hotel booking page",
  "id": "standard-search",
  "keyword": "Feature",
  "tags": [
    {
      "line": 4,
      "name": "@tag"
    }
  ]
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "User has navigated to Trivago website",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "User provides input of place and type",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Clicks on the search button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "User is redirected to the search results page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.user_has_navigated_to_Trivago_website()"
});
formatter.result({
  "duration": 33995440223,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_provides_input_of_place_and_type()"
});
formatter.result({
  "duration": 2724337412,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.clicks_on_the_search_button()"
});
formatter.result({
  "duration": 3770093459,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_is_redirected_to_the_search_results_page()"
});
formatter.result({
  "duration": 9283773,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "As a user, he/she should be able to filter the results based on choices",
  "description": "",
  "id": "standard-search;as-a-user,-he/she-should-be-able-to-filter-the-results-based-on-choices",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 14,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "User is on the search results page",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "chooses for custom applied filters",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "clicks on Done button",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "user sorts the results by price only",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "User sees the relevant recommendations",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.user_is_on_the_search_results_page()"
});
formatter.result({
  "duration": 11629836,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.chooses_for_custom_applied_filters()"
});
formatter.result({
  "duration": 2468258474,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.clicks_on_Done_button()"
});
formatter.result({
  "duration": 1391695707,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_sorts_the_results_by_price_only()"
});
formatter.result({
  "duration": 5641390632,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_sees_the_relevant_recommendations()"
});
formatter.result({
  "duration": 18405673225,
  "status": "passed"
});
});