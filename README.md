# MontyHallParadoxProgram
This is a program that empirically shows the non-intuitive event of the Monty Hall Paradox (search 'Monty Hall Paradox' on the internet for more details on the paradox).

To run this program, one can pull the code directly and run the Main class in the bin directory.

Another way to run this program and to ensure consistency across different environments is via the Dockerfile.

Build the Dockerfile in the MontyHallParadox folder:
docker build -t <tag-name> .

Run the program like this:
docker container run <tag-name>
  
One can also pull the image from my Docker Hub account like this:
docker image pull codesorcerer/montyhallparadox

Use the same run command but with the tag name given in my repo.

For more information on my images visit https://hub.docker.com/repository/docker/codesorcerer/montyhallparadox
