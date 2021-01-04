# IOLogger

This Bukkit plugin captures all chat lines and commands entered and stores them in matching log files, one per day.

No configuration, no, commands, no permissions; it runs quietly in the background.

## Output

### Chat
File: `plugins/IOLogger/logs/chat/DATE.txt`

```
00:00:45 | Doctacosa@world(248,65,65): [Doctacosa joined]
00:01:03 | Doctacosa@world(248,65,64): Hello world!
00:02:42 | Doctacosa@world(2598,59,-1959): [Doctacosa left]
```

### Commands
File: `plugins/IOLogger/logs/commands/DATE.txt`

```
00:01:20 | Doctacosa@world(350,70,72): /time
```
