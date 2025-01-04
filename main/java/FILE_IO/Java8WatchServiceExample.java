package FILE_IO;

import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

import static java.nio.file.StandardWatchEventKinds.*;


public class Java8WatchServiceExample {
    private final WatchService watcher;
    private final Map<WatchKey, Path> dirWatchers;

    public Java8WatchServiceExample(Path dir) throws IOException {
        this.watcher = FileSystems.getDefault().newWatchService();
        this.dirWatchers = new HashMap<WatchKey, Path>();

        // Register the given directory and its sub-directories
        scanAndRegisterDirectories(dir);
    }

    // Register the given directory, and its sub-directories, with the WatchService.
    private void scanAndRegisterDirectories(final Path start) throws IOException {
        // Register directory and sub-directories
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                registerDirWatchers(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }


    // Register a single directory with the WatchService.
    private void registerDirWatchers(Path dir) throws IOException {
        WatchKey key = dir.register(watcher, ENTRY_CREATE,
                ENTRY_DELETE, ENTRY_MODIFY);
        dirWatchers.put(key, dir);
    }

    // Process all events for keys queued to the watcher.
    @SuppressWarnings({"rawtypes", "unchecked"})
    void processEvents() {
        while (true) {
            WatchKey key;
            try {
                // Wait for a key to be signaled
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }

            Path dir = dirWatchers.get(key);
            if (dir == null) {
                System.err.println("WatchKey not recognized!");
                continue;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind kind = event.kind();

                // Context for directory entry event is the file name
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path name = ev.context();
                Path child = dir.resolve(name);

                System.out.format("%s: %s\n", event.kind().name(), child);

                // If a directory is created, register it and its sub-directories
                if (kind == ENTRY_CREATE) {
                    try {
                        if (Files.isDirectory(child)) {
                            scanAndRegisterDirectories(child);
                        }
                    } catch (IOException x) {
                        // Ignore for now
                    }
                } else if (kind.equals(ENTRY_DELETE)) {
                    if (Files.isDirectory(child)) dirWatchers.remove(key);
                }
            }

            // Reset the key -- if it is no longer valid, remove it from the map
            boolean valid = key.reset();
            if (!valid) {
                dirWatchers.remove(key);

                // Exit if no directories are accessible
                if (dirWatchers.isEmpty()) {
                    break;
                }
            }
        }
    }
}
