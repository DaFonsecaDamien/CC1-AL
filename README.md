# Architecture Logicielle CC1-AL

- Architecture Logicielle CC1 4AL2.
- Conception & développement d'un module logiciel de gestion des inscriptions d'une solution e-commerce, comportant une fonction d'ajout d'un membre.


## Modalités

- Respect des patterns logiciels et des concepts objets (pattern repository, injection de dependances, programmation par interfaces, etc...)
- Respect de 'l'intention' dans le code.
- Justifier certains critère de qualité.
- Langage Java 11 ou +

## Conception du logiciel

- Injection de dépendance : Pour créer dynamiquement les dépendances entre les différents objets.
- Value Object : Permet de définir un objets avec des attributs et du comportement (Incrémentation, etc...).
- Entity : Définit par leur identité et non par leurs attributs qui peuvent changer dans le temps.
- Infrastructure Service/Controller : Gestion des différentes méthodes (module de service web).
- Repository : Collection augmentée (recherches + fonctionnalités spécifiques) Uniquement métier.
- NoSuchEntityException : Création de notre propre exception pour la recherche byID.
- ApplicationLogger : Pour la gestion de message.
- StubPayment : Pour simuler le payement simplement.
- Validator : Vérification du Membership avec un Predicate, simulation d'un Membership valide et invalide.
- InMemoryMembership : afin de stocker les membres valide et ajouté à l'aide de l'inscription.

## Choix d'implémentation

Application réalisé avec une approche DDD (Domain-Driven Design).
Domain : Contient l'ensemble des informations relatives au métier.
Infrastructure : Contient les implémentations des différentes interfaces, se comporte comme une bibliothèque de support au domaine.

- Utilisation de Commande et d'Event lors de la création de membres. Lancement d'évenements partagé grâce à un bus d'évenement.
- Utilisation de Spring.
- Gestion des membres grâce au repository pattern.

## License
[MIT](https://choosealicense.com/licenses/mit/)
