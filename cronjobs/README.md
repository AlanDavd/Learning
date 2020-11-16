# Cron Jobs

Cron is a utility that you can find in a Unix like operating system ([Info for Windows](https://www.technipages.com/scheduled-task-windows)). Cron makes it easy to automate a wide range of tasks since it is used to schedule commands at specific timeframes. These scheduled commands or tasks are known as "Cron Jobs".

Some examples of the usage of Cron are:

- Running scheduled backups
- Monitoring disk spaces
- Deleting files periodically which are no longer required

and more.

## Commands

Display the contents of the crontab file of the currently logged in user:

```bash
$ crontab -l
```

Edit the current user's cron jobs:

```bash
$ crontab -e
```

To edit the crontab of a different user, do:

```bash
$ crontab -u <user_name> -e
```

To remove all cron jobs for the current user:

```bash
$ crontab -r
```

## Format

The typical format of a cron job is:

```
Minute(0-59) Hour(0-24) Day_Of_Month(1-31) Month(1-12) Day_Of_Week(0-6) command_to_execute
```

The asterisks `*` correspond to specific blocks of time.

- To run a cron job at every minute, the format should be:

```bash
# Every minute
# 10:00 -> 10:01 -> 10:02 -> 10:03
$ * * * * * <command>
```

- To run a cron job at every 5th minute, the format should be:

```bash
# Every five minutes
# 10:00 -> 10:05 -> 10:10 -> 10:15
$ */5 * * * * <command>
```

- To run a cron job at every quarter hour (every 15th minute):

```bash
# Every 15 minutes
# 10:00 -> 10:15 -> 10:30 -> 10:45
$ */15 * * * * <command>
```

- To run a cron job every hour at minute 30:

```bash
# Every 30th minute
# 10:30 -> 11:30 -> 12:30
$ 30 * * * * <command>
```

- You can also define multiple time intervals separated by commas:

```bash
# This cron job will run three times every hour
# At minute 0, 5, and 10
# 10:00, 10:05, 10:10 -> 11:00, 11:05, 11:10
$ 0,5,10 * * * * <command>
```

- To run a job every 2 hours:

```bash
# 10:00 -> 12:00 -> 14:00
$ 0 */2 * * * <command>
```

- To run a job every day:

```bash
# It will run at 00:00
$ 0 0 * * * <command>
```

- To run a job every day at 3am:

```bash
$ 0 3 * * * <command>
```

- To run a job every Sunday:

```bash
$ 0 0 * * SUN <command>
or
$ 0 0 * * 0 <command>
```

- To run a job on every day-of-week from Monday through Friday:

```bash
# Every weekday
$ 0 0 * * 1-5 <command>
```

- Run a job every month:

```bash
# At 00:00 on day-of-month 1:
$ 0 0 1 * * <command>
```

- Run a job at 16:15 on day-of-month 1

```bash
$ 15 16 1 * * <command>
```

We can also use the following strings to define job.

- `@reboot` ⇒ Run once, at startup.
- `@yearly` ⇒ Run once a year.
- `@annually` ⇒ (same as `@yearly`).
- `@monthly` ⇒ Run once a month.
- `@weekly` ⇒ Run once a week.
- `@daily` ⇒ Run once a day.
- `@midnight` ⇒ (same as `@daily`).
- `@hourly` ⇒ Run once an hour.

- To run a job every time the server is rebooted

```
$ @reboot <command>
```

## Resources

You don't need to memorize crontab syntax. The following two websites helps you to easily generate a crontab expression based on your inputs.

- [Crontab Generator](https://crontab-generator.org/)
- [Crontab.guru](https://crontab.guru/)
