Feature: inscription utilisateur
  Scenario: inscription avec des données valide
    Given l'utilisateur est dans la page d'inscription
    When l'utilisateur saisi l'email et le mot de passe valide
    And l'utilisateur clique sur le bouton inscription
    Then inscription réussi et affichage de la page login


  Scenario: inscription avec email valide et mot de passe invalide
    Given l'utilisateur est dans la page d'inscription
    When l'utilisateur saisi email valide et mot de passe invalide
    And l'utilisateur clique sur le bouton inscription
    Then inscription echoué


  Scenario: inscription avec un valide mail et mot de passe vide
    Given l'utilisateur est dans la page d'inscription
    When l'utilisateur saisi un mail valide et mot de passe vide
    And l'utilisateur clique sur le bouton inscription
    Then affichage d'un message d'erreur