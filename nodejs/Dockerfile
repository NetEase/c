FROM hub.c.163.com/nce2/nodejs:0.12.2
COPY ./ /srv/www
WORKDIR /srv/www
RUN cnpm install -d
CMD ["node", "app.js"]
