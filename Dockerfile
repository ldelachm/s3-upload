FROM amazon/aws-cli:2.28.22
COPY . .
ARG AWS_ACCESS_KEY_ID
ARG AWS_SECRET_ACCESS_KEY
ARG AWS_SESSION_TOKEN
RUN aws sts get-caller-identity
RUN aws s3 cp requirements.txt s3://upload-to-s3-with-codebuild-test
