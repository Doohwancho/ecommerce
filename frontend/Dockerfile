FROM node:16.18.1

RUN mkdir /app
WORKDIR /app

ENV PATH /app/node_modules/.bin:$PATH
COPY package.json /app/package.json
RUN npm install
COPY . .
EXPOSE 3000

CMD ["npm", "run", "start"]

