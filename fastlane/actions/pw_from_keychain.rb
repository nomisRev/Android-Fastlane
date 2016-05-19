module Fastlane
  module Actions
      class PwFromKeychainAction < Action
      def self.run(params)
        service = params[:service]
        account = params[:account]

        shell_command = ["security 2>&1 >/dev/null find-generic-password -s", service, " -ga ", account, " | ruby -e 'print $1 if STDIN.gets =~ /^password: \"(.*)\"$/'"].join

        pwd = Fastlane::Actions.sh(shell_command, log: false)
        return pwd
      end

      #####################################################
      # @!group Documentation
      #####################################################

      def self.description
        "Retrieves password from keychain"
      end

      def self.available_options
        [
          FastlaneCore::ConfigItem.new(key: :service,
                                       description: "Service to match in keychain"),

          FastlaneCore::ConfigItem.new(key: :account,
                                       description: "Account to match in keychain")
        ]
      end

      def self.return_value
        "The password in plain text from the keychain"
      end

      def self.authors
        ["nomisRev"]
      end

      def self.is_supported?(platform)
        true
      end
    end
  end
end
