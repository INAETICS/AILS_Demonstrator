from os import listdir
import argparse
import re

# Only execute this code if this module is not imported. So:
# $ python folder_to_gosh.py
# or
# $ ./folder_to_gosh.py
if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='Generate a (partly) GoSH ' +
            'file given a directory of jars')

    # this should have been type=open, however we have to check that the 
    # input_directory is actually a dir, which is not possible with the 
    # argparse library
    parser.add_argument('input_directory')

    parser.add_argument('-o', dest='output', help='File to output the GoSH ' +
            'file to, stdout if kept empty')

    args = parser.parse_args()

    output_text = ""

    try:
        # list a folder, remove any file (or directory) that does not end 
        # with .jar
        files = filter(lambda x: x.endswith('.jar'), 
                       listdir(args.input_directory))

        # Pattern that matches version numbers in jar names, the group <vnum> 
        # is the actual version number, the total match is dash versionnumber
        pattern = re.compile('(-)?(?P<vnum>\d+(.\d+(.\d+)?)?)\.jar')

        for jar in files:
            version = 0

            # find the first occurence of a version string in the jar name
            match = pattern.search(jar)

            if match:
                # the version of this artifact was matched, and is to be found 
                # in the <vnum> captured group
                version = match.groupdict()['vnum']

                # remove the version number from the artifact name for the 
                # config. The sub method just substitutes the first match of 
                # the pattern, so in this case the whole version string
                jar = pattern.sub('', jar)

            output_text += '["identity"="{}" "version"="{}"]\n'.format(jar, 
                                                                       version)


        # only write to file if there was one specified
        if args.output:
            try:
                # only keep the file reference for as long as we need it
                with open(args.output, 'w+') as f:
                    f.write(output_text)
            except IOError as e:
                print('unable to write to output file')
        else:
            print(output_text)
    except FileNotFoundError:
        print('input directory is not a valid directory!')
