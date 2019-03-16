# WDD #TechItForward Hackathon CYF - Slack Student Tracker

The Charity Code Your Future wants to be able to track student activity on their Slack workspace.

## This App scrapes the conversation.histories API

It will be able to scrape other APIs too – for this the base URL needs to be edited to contain the method name for the api in question. (Please note different APIs ask for different Ids. Histories wants the channel id. Others may ask for user Ids)

Workspace tokens are kept local as Environment variable, which need to be set in your ide. Once a frontend is implemented these can be queried when logging in.

### Currently

The app is able to get raw json from the api and extract the meaningful data from the json string and store these as a POJO.

### Future

The POJO can be used to persist the interesting data in the database. 

A call should be made to the student records table in the charity's database to be able to cross check students' activity and also isolate non-participating students. These could be flagged up to make it clearer where volunteers may need to intervene or reach out.

##### other useful calls

Get info on your team's Slack channels, create or archive channels, invite users, set the topic and purpose, and mark a channel as read.
`channels.history` - Fetches history of messages and events from a channel
URL: 
```
https://slack.com/api/channels.history?token=<workspaceToken>&channel=<channelId>&pretty=1
```
`channels.replies` - Retrieves a thread of messages posted to a channel
URL: 
```
https://slack.com/api/channels.replies?token=<workspaceToken>&channel=<channelId>&thread_ts=<thread timestamp>&pretty=1
```
Interface with all kinds of conversations the same way, whether they're public or private channels, direct messages, or otherwise.
`conversations.history` - Fetches a conversation's history of messages and events
`conversations.members` -  Retrieve members of a conversation
```
URL: https://slack.com/api/conversations.members?token=<workspaceToken>&channel=<channelId>&pretty=1
```
`conversations.replies` - Retrieve a thread of messages posted to a conversation

Get info on your team's private channels.
`group.history` - Fetches history of messages and events from a private channel

`group.replies` - Retrieve a thread of messages posted to a private channel

Get info on your direct messages.
`im.history` - Fetches history of messages and events from direct message channel

`im.replies` - Retrieve a thread of messages posted to a direct message conversation

Get info on your multiparty direct messages.
`mpim.history` - Fetches history of messages and events from a multiparty direct message

`mpim.replies` - Retrieve a thread of messages posted to a direct message conversation from a multiparty direct message

Search your team's files and messages.
`search.messages` - Searches for messages matching a query
URL: 
```
https://slack.com/api/search.messages?token=<workspaceToken>&query=hello&pretty=1
```
Get info on members of your Slack team.
`users.conversations` - List conversations the calling user may access
URL: 
```
https://slack.com/api/users.conversations?token=<workspaceToken>&user=<userId>&pretty=1
```
`users.getPresence` - Gets user presence information
URL: 
```
https://slack.com/api/users.getPresence?token=<workspaceToken>&user=<userId>&pretty=1
```
`users.list` - Lists all users in in the workspace
URL: 
```
https://slack.com/api/users.list?token=<workspaceToken>&pretty=1
```
`users.lookupByEmail` - Find a user with an email address
URL: to be determined

It's important to note that `.history` methods only give you the parent messages. To see any threads of replies you need to use `.replies`.