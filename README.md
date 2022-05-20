# The_Next_Tarantino

This application was generated using JHipster 7.8.1, you can find documentation and help
at [https://www.jhipster.tech](https://www.jhipster.tech).

## Run Locally

To run the project locally, the easiest way would be
using [Docker](https://docs.docker.com/get-docker/) and the `docker-compose.yml`. If you have `npm`
installed you can use the existing `npm` script to build the image. From the project folder just
simply execute the command `npm run java:docker`. After the image has been built just execute the
following command `docker compose -f src/main/docker/docker-compose.yml up`.

## Project Structure

Node is required for generation and recommended for development. `package.json` is always generated
for a better development experience with prettier, commit hooks, scripts and so on.

In the project root, JHipster generates configuration files for tools like git, prettier, eslint,
husk, and others that are well known and you can find references in the web.

`/src/*` structure follows default Java structure.

- `.yo-rc.json` - Yeoman configuration file
  JHipster configuration is stored in this file at `generator-jhipster` key. You may
  find `generator-jhipster-*` for specific blueprints configuration.
- `.yo-resolve` (optional) - Yeoman conflict resolver
  Allows to use a specific action when conflicts are found skipping prompts for files that matches a
  pattern. Each line should match `[pattern] [action]` with pattern been
  a [Minimatch](https://github.com/isaacs/minimatch#minimatch) pattern and action been one of skip (
  default if ommited) or force. Lines starting with `#` are considered comments and are ignored.
- `.jhipster/*.json` - JHipster entity configuration files

- `npmw` - wrapper to use locally installed npm.
  JHipster installs Node and npm locally using the build tool by default. This wrapper makes sure
  npm is installed locally and uses it avoiding some differences different versions can cause. By
  using `./npmw` instead of the traditional `npm` you can configure a Node-less environment to
  develop or test your application.
- `/src/main/docker` - Docker configurations for the application and services that the application
  depends on
