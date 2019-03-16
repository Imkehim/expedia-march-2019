# WDD #TechItForward Hackathon CYF - Slack Student Tracker

The Charity Code Your Future wants to be able to track student activity on their Slack workspace.

## This App scrapes the conversation.histories API

It will be able to scrape other APIs too – for this the base URL needs to be edited to contain the method name for the api in question. (Please note different APIs ask for different Ids. Histories wants the channel id. Others may ask for user Ids)

Workspace tokens are kept local as Environment variable, which need to be set in your ide. Once a frontend is implemented these can be queried when logging in.

###Currently

The app is able to get raw json from the api and extract the meaningful data from the json string and store these as a POJO.

###Future

The POJO can be used to persist the interesting data in the database. 
