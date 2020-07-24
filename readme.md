#Tsimul
#### Quickly build and test your IoT application.

Tsimul is a sensors simulator. It allows one to quickly up and run an IoT project without
worrying about setting up an actual set of sensors.

##Easy and Intuitive configuration:

- You configure your simulator by provinding to tsimul a json file.
    This json file follows a Json Schema which describe how you can configure the different
    components of your simulator.
    NB: The schema files is written in Json Schema IETF version draft-7.
    
##An Extensible system:

Thanks to a solid and modular architecture, the features of tsimul can be exetended with plugins.

By default tsimul comes with 3 categories of plugins
- **Storage**:
    - MongoDB
    - Cassandra
- **Transport**:
    - HTTP
    - Server Sent Event
    - WebSocket
    - Kafka for the messaging
- **Analytics**:
    - Basics: For numerical data (avg, min, max, sum, etc)
    - Advanced: (With the use of a computing engine such as Apache Spark)

---

#### Construit et test rapidement ton application d'IoT.

Tsimul est un simulateur de capteurs. Il se veut de faciliter 
la simulation des données générer par des capteurs.

**La force de Tsimul réside en deux points:**
- La configuration intuitive:\
La configuration du système se fait à l'aide d'un fichier
JSON, où l'utilisateur décrit les composants souhaités
(Capteurs et Actionneurs), et aussi les paramètres des
plugins intégrés au système. Ce fichier JSON respecte la
norme Json Schema IETF version draft-7.

- Le système de plugins\
Les plugins sont des routines qui permettent d'augmenter
les fonctionalités du sytème.

Par défaut, Tsimul vient avec trois types de plugins:
Transport, Stockage et Analystics.
- Transport: Permet de transporter les données génénées
par le système sur internet via HTTP, WebSockets ou
Messaging (avec Kafka)
- Storage: Permet de stocker les données des capteurs dans
une base de données NoSQL (MongoDB ou Cassandra)
- Analytics: Permet d'effectuer des traitements des données
des capteurs et de les visualiser grâce au dashboard fournit.

Last Edit:
- Some nice ideas are coming soon, like auto deploy for deploying the system on a cloud; Dashboard for visualizing and setting up the system.
