Feature: authentification

  Scenario Outline: connexion utilisateur avec des données valides et invalides

    Given l'utilisateur se positionne dans page login
    When l'utilisateur saisi "<email>" et le "<password>"
    And clique sur le button login
    Then je devrais "<resultat>"
    Examples:
      | email | password | resultat |
      | anassroudane@gmail.com | Livinglove12345 | etre connecté |
      | anassroudane@.com | 1234 | ne pas etre connecté |
      | anassroudane@gmail.com | anass | ne pas etre connecté |
      |           | Livinglove12345 | ne pas etre connecté |