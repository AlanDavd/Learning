package com.company.importer;

import java.io.File;
import java.io.IOException;

// tag::importer[]
interface Importer {
    Document importFile(File file) throws IOException;
}
// end::importer[]
