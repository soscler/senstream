
*SenML est une spécification qui se veut de faciliter la représentation et le transport des données 
des capteurs sur internet.*

## Comment gérer les données senML

- Il faut faire la conversion vers senML en mode lazy
    - ajouter une fonction asSenML() dans sensor qui convertit une mesure vers senML.
    - Faire attention avec les champs de base 
- Cette fonction lazy peut donc être utilisée dans plusieurs niveaux du système :
    - Affichage, Transport, etc.

## Comment gérer les données batch senML avec notre IOTSystem ?

- Au niveau du system. Pour cela il deux types fonction
     - Une fonction qui produit le batch pour plusieurs capteurs du system.\
        Cette fonction doit s'assurer de ne pas dupliquer des champs de base.
     - Une fonction qui produit le batch pour un capteur, mais sous plusieurs intervalles de temps.\
        Cette fonction doit s'assurer de ne pas dupliquer des champs de base.
- Au niveau du capteur :
    - Une fonction qui produit le batch pour ce capteur, mais sous plusieurs intervalles de temps.\
    Cette fonction doit s'assurer de ne pas dupliquer des champs de base.


# Version 1.0.0

- Tous les capteurs ont la capacité de produire des données senML.
- Tous les capteurs ont une horloge interne
- Tous les capteurs ont la capacité d'affichage (écran, display)
- Tous les capteurs produisent des données numériques (double)

# Version 1.1.0

- Possibilité de produire des données de différents type (double, boolean, string).
- Certains capteurs sont basiques :
    - Ils n'ont pas la capacité de produire leurs données sous format senML.\
    Dans ce cas le système doit s'en occuper.
    - Ils n'ont pas d'horloge interne.\
    Dans ce cas le système doit s'en occuper.
- Ajouter un système de stockage dédié.
- Pouvoir sérialiser le système en entier (capteurs, mesures, configurations, etc.).
