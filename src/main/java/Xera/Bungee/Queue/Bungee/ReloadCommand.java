package Xera.Bungee.Queue.Bungee;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class ReloadCommand extends Command {
    XeraBungeeQueue plugin;

    public ReloadCommand(XeraBungeeQueue plugin) {
        super("lbq");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 1 || args[0].equalsIgnoreCase("help"))  {
            sender.sendMessage(ChatColor.DARK_BLUE + "----------------");
            sender.sendMessage(ChatColor.GOLD + "XeraBungeeQueueBukkit");
            sender.sendMessage(ChatColor.GOLD + "/lbq help");
            sender.sendMessage(ChatColor.GOLD + "/lbq reload");
            sender.sendMessage(ChatColor.GOLD + "/lbq version");
            sender.sendMessage(ChatColor.GOLD + "/lbq stats");
            sender.sendMessage(ChatColor.DARK_BLUE + "----------------");
            return;
        }

        if (args[0].equalsIgnoreCase("version")) {
            sender.sendMessage(ChatColor.DARK_BLUE + "----------------");
            sender.sendMessage(ChatColor.GOLD + "XeraBungeeQueueBukkit");
            sender.sendMessage(ChatColor.GOLD + "Version " + plugin.getDescription().getVersion() + " by");
            sender.sendMessage(ChatColor.GOLD + "Nate Legault");
            sender.sendMessage(ChatColor.DARK_BLUE + "----------------");
            return;
        }

        if (args[0].equalsIgnoreCase("stats")) {
            sender.sendMessage(ChatColor.DARK_BLUE + "----------------");
            sender.sendMessage(ChatColor.GOLD + "Queue stats");
            sender.sendMessage(ChatColor.GOLD + "Priority: " + ChatColor.BOLD + XeraBungeeQueue.priorityqueue.size());
            sender.sendMessage(ChatColor.GOLD + "Regular: " + ChatColor.BOLD + XeraBungeeQueue.regularqueue.size());
            sender.sendMessage(ChatColor.DARK_BLUE + "----------------");
            return;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            if (sender.hasPermission(Lang.ADMINPERMISSION)) {
                plugin.processConfig();

                sender.sendMessage(ChatColor.DARK_BLUE + "----------------");
                sender.sendMessage(ChatColor.GOLD + "XeraBungeeQueueBukkit");
                sender.sendMessage(ChatColor.GREEN + "Config reloaded");
            } else {
                sender.sendMessage(ChatColor.DARK_BLUE + "----------------");
                sender.sendMessage(ChatColor.GOLD + "XeraBungeeQueueBukkit");
                sender.sendMessage(ChatColor.RED + "You do not");
                sender.sendMessage(ChatColor.RED + "have permission");
            }
            sender.sendMessage(ChatColor.DARK_BLUE + "----------------");
        }

    }
}