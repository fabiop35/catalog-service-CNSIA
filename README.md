Book Cloud Native Spring in Action.

#Dependency with Postgres, start the service
pg_ctl -D ~/postgres_data -l ~/logfile start

#Run the application using the production profile
java -jar build/libs/catalog-service-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod

#Build image
docker build -t catalog-service .

#run the catalog-service container
docker run -d --name catalog-service --net catalog-network -p 9001:9001 -e SPRING_DATASOURCE_URL=jdbc:postgresql://polar-postgres:5432/polardb_catalog -e SPRING_PROFILES_ACTIVE=testdata -e SPRING_CLOUD_CONFIG_URI=http://config-service:8888 catalog-service

